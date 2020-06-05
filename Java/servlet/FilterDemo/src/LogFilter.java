import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

/**
 * Filter常见使用场景:
 * 身份验证过滤器（Authentication Filters）。
 * 数据压缩过滤器（Data compression Filters）。
 * 加密过滤器（Encryption Filters）。
 * 触发资源访问事件过滤器。
 * 图像转换过滤器（Image Conversion Filters）。
 * 日志记录和审核过滤器（Logging and Auditing Filters）。
 * MIME-TYPE 链过滤器（MIME-TYPE Chain Filters）。
 * 标记化过滤器（Tokenizing Filters）。
 * XSL/T 过滤器（XSL/T Filters），转换 XML 内容。
 */

@WebFilter(filterName = "LogFilter")
public class LogFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // Get the IP of client request.
        String ip = req.getRemoteAddr();

        // Log the ip
        System.out.println(new Date().toString() + ": " + ip);

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        // Get init parameter in web.xml.
        String param = config.getInitParameter("ParameterName");
        System.out.println("ParameterName:" + param);
    }
}
