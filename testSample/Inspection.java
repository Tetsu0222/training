package testSample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class Inspection extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public Inspection() {
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
		String id = request.getParameter("ID");

		//アンケートデータ（SurveyDto型）の作成
		Sample_DTO sdto = new Sample_DTO();
		sdto.setName( id );

		//アンケートデータをDBに登録
		Sample_BusinessLogic bl = new Sample_BusinessLogic();
		boolean succes = bl.executeInsert(sdto);

		//リダイレクト
		if (succes) {
			response.sendRedirect("htmls/finish.html");
		} else {
			response.sendRedirect("htmls/error.html");
		}
	}
}