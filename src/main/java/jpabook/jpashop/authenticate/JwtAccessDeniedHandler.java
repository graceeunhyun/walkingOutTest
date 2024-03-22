package jpabook.jpashop.authenticate;

import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, org.springframework.security.access.AccessDeniedException accessDeniedException) throws java.io.IOException, javax.servlet.ServletException {
        //필요한 권한이 존재하지 않는 경우에 403 Forbidden 에러를 리턴하기 위한 class
        response.sendError(javax.servlet.http.HttpServletResponse.SC_FORBIDDEN);
    }
}
