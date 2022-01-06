package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationScope02
 */
@WebServlet("/ApplicationScope02")
public class ApplicationScope02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationScope02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		ServletContext application = getServletContext(); // 웹 애플리케이션 ServletContext 객체 얻어옴 -> 값을 얻음
		try {
		int value = (int)application.getAttribute("value"); // value 값을 얻어냄
		value++;
		application.setAttribute("value", value); // "value"에게 value에 저장된 값을 맡김
	
		out.println("<h1>value : " + value + "</h1>");
		}catch (NullPointerException e) {
			out.print("value의 값이 설정되지 않았습니다.");
		}
		
	}

}
