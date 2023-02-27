package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**----------------------------------------------------------------------*
 *■■■Loginクラス■■■
 *概要：サーブレット
 *詳細：HTML文書（ログイン画面）を出力する。
 *----------------------------------------------------------------------**/
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");  //文字コードをUTF-8で設定

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//セッションからユーザーデータを取得
		HttpSession session           = request.getSession();
		UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");

		//ログイン状態によって表示画面を振り分ける
		// ※ログイン状態はセッション上からユーザーデータを取得できたか否かで判断
		//    ユーザーデータを取得できた　　　→既にログインされている
		//    ユーザーデータを取得できなかった→まだログインされていない
		if (userInfoOnSession != null) {
			//ログイン済：ホーム画面へ転送
			response.sendRedirect("InputSurvey");
		}else{
			//未ログイン：HTML文書（ログイン画面）の出力
			out.println("<html>                                                             ");
			out.println("<head>                                                             ");
			out.println("  <title>ログイン画面</title>                                      ");
			out.println("</head>                                                            ");
			out.println("<body>                                                             ");
			out.println(" <h1>ログインSample②（ログイン画面）</h1>                         ");
			out.println("  <form action=\"ExecuteLogin\" method=\"post\">                   ");
			out.println("    <p>ユーザーID：<br>                                            ");
			out.println("      <input type=\"text\" name=\"USER_ID\" maxlength=\"20\">      ");
			out.println("    </p>                                                           ");
			out.println("    <p>パスワード：<br>                                            ");
			out.println("      <input type=\"password\" name=\"PASSWORD\" maxlength=\"20\"> ");
			out.println("    </p>                                                           ");
			out.println("    <input type=\"submit\" value=\"ログイン\">                     ");
			out.println("  </form>                                                          ");
			out.println("</body>                                                            ");
			out.println("</html>                                                            ");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
