package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestSample2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	public TestSample2() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//レスポンスの文字コードを設定
		response.setContentType("text/html;charset=UTF-8");
		
		//リクエストの文字コードを設定
		request.setCharacterEncoding("UTF-8");
		
		//リクエストパラメータを取得
		int id = Integer.parseInt( request.getParameter("ID") );
		
		//入力データをビジネスロジックへ送信
		Sample_BL bl = new Sample_BL( id );
		Sample_DTO dto = bl.select();
		//String selectResult = dto.Result();
		
		
		
		
		//リダイレクト
		if ( dto.isSuccess()) {
			response.sendRedirect("htmls/finish.html");
		} else {
			response.sendRedirect("htmls/error.html");
		}
		
	}
	
	
	
}
