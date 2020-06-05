import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
    public static final String URL = "jdbc:mysql://localhost:3306/CompanyTest?serverTimezone=UTC&characterEncoding=UTF-8";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        Employee em1 = createEmployee(1, 15, "Cabbet", "Long");
        Employee em2 = createEmployee(2, 15, "Frances", "Pan");
        Employee em3 = createEmployee(3, 16, "Bill", "Chen");

        List<Employee> ems = new ArrayList<Employee>();
        ems.add(em2);
        ems.add(em3);

        EmployeeJDBC jdbc = new EmployeeJDBC();

        jdbc.addOneEmployee(em1);
        printEmployees(jdbc.getAllEmployees());

        jdbc.addEmployees(ems);
        printEmployees(jdbc.getAllEmployees());

        /**
         * output:
         * Connect DataBase: CompanyTest successfully!
         * Create table: Employee successfully!
         * -----------
         * id: 1	name: Cabbet Long	age: 15
         * -----------
         * -----------
         * id: 1	name: Cabbet Long	age: 15
         * id: 2	name: Frances Pan	age: 15
         * id: 3	name: Bill Chen	age: 16
         * -----------
         */
    }

    private static Employee createEmployee(int id, int age, String first, String last) {
        Employee em = new Employee();

        em.setId(id);
        em.setAge(age);
        em.setFirstName(first);
        em.setLastName(last);

        return em;
    }

    private static void printEmployees(List<Employee> ems) {
        System.out.println("-----------");
        for (Employee em : ems) {
            System.out.printf("id: %d\tname: %s %s\tage: %d\r\n",
                    em.getId(), em.getFirstName(), em.getLastName(), em.getAge());
        }
        System.out.println("-----------");
    }
}


class EmployeeJDBC {
    private Connection connection;

    public static final String URL = "jdbc:mysql://localhost:3306/CompanyTest?serverTimezone=UTC&characterEncoding=UTF-8";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static final String TABLE_NAME = "Employee";

    private String createTableEmployee = "CREATE TABLE Employee(id int not null,age int not null,first varchar (255),last varchar(255));";
    private PreparedStatement addEmployeeStmt;
    private PreparedStatement deleteAllEmployeeStmt;
    private PreparedStatement getAllEmployeeStmt;

    private Statement statement;

    public EmployeeJDBC() {
        connect2DB();
        checkTable();
        prepareStatements();
    }

    private void prepareStatements() {
        try {
            addEmployeeStmt = connection.prepareStatement("INSERT INTO Employee (id, age, first, last) VALUES (?, ?, ?, ?)");
            deleteAllEmployeeStmt = connection.prepareStatement("DELETE * FROM Employee");
            getAllEmployeeStmt = connection.prepareStatement("SELECT id, age, first, last FROM Employee");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void checkTable() {
        if (connection == null) return;
        try {
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
            while (rs.next()) {
                if (TABLE_NAME.equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    return;
                }
            }

            // if there's no table named "Employee", create it
            statement.executeUpdate(createTableEmployee);
            System.out.println("Create table: Employee successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connect2DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            System.out.println("Connect DataBase: CompanyTest successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearEmployees() {
        try {
            deleteAllEmployeeStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addOneEmployee(Employee em) {
        int count = 0;
        try {
            addEmployeeStmt.setInt(1, em.getId());
            addEmployeeStmt.setInt(2, em.getAge());
            addEmployeeStmt.setString(3, em.getFirstName());
            addEmployeeStmt.setString(4, em.getLastName());

            count = addEmployeeStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public void addEmployees(List<Employee> ems) {
        try {
            connection.setAutoCommit(false);

            for (Employee em : ems) {
                addOneEmployee(em);
            }

            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();

        try {
            ResultSet rs = getAllEmployeeStmt.executeQuery();

            while (rs.next()) {
                Employee em = new Employee();
                em.setId(rs.getInt("id"));
                em.setAge(rs.getInt("age"));
                em.setFirstName(rs.getString("first"));
                em.setLastName(rs.getString("last"));
                employees.add(em);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }
}

class Employee {
    private int id;
    private int age;
    private String firstName;
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
