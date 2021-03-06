package br.com.cateno.cotacao.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoggerRequestFilter extends OncePerRequestFilter implements Ordered {

    private final static Logger LOG = LoggerFactory.getLogger(LoggerRequestFilter.class);

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 10;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        ContentCachingRequestWrapper wrapperRequest = new ContentCachingRequestWrapper(request);

        // Proceed to next filter
        filterChain.doFilter(wrapperRequest, response);

        //log payload
        logPayload(wrapperRequest);
    }

    private void logPayload(ContentCachingRequestWrapper wrapperRequest) {
        try {

            ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(wrapperRequest, ContentCachingRequestWrapper.class);

            if (wrapper != null) {
                byte[] buffer = wrapper.getContentAsByteArray();
                if (buffer.length > 0) {

                    String payload = new String(buffer, 0, buffer.length, wrapper.getCharacterEncoding());
                    LOG.info("Payload: " + payload);

                }
            }
        } catch (Exception e) {
            LOG.error("Error to read payload", e);
        }
    }

}
