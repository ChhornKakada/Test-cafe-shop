package cafe.shop.testing.cafe.shop.login_security;
 
import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
 
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
         
        String redirectURL = request.getContextPath();
         
        if (userDetails.hasRole("Admin")) {
            redirectURL = "admin/cashier";
        } else if (userDetails.hasRole("Cashier")) {
            redirectURL = "cashier/order";
        }
         
        response.sendRedirect(redirectURL);
         
    }
 
}