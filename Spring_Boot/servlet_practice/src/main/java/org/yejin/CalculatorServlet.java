package org.yejin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yejin.calculator.domain.Calculator;
import org.yejin.calculator.domain.PositiveNumber;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends GenericServlet {
    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);
    private ServletConfig servletConfig;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        log.info("service");
        // 1. client로부터 값 얻어옴
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        // 2. Domain으로 부터 계산
        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }
}
