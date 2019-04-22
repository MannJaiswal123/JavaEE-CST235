package Assignmentaa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		if(firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty())
		{
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			
			request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
		}
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		
		request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
		//response.getWriter().append("Hello my name is ").append(" Mann" + "  " +  "Jaiswal");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

}
