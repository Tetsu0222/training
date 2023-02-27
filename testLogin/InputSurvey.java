package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**----------------------------------------------------------------------*
 *■■■InputSurveyクラス■■■
 *概要：サーブレット
 *詳細：HTML文書（回答入力画面）を出力する。
 *----------------------------------------------------------------------**/
public class InputSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InputSurvey() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");  //文字コードをUTF-8で設定
		
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定

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
			//ログイン済：ホーム画面を出力
			
			//セッションから取得したユーザーデータからユーザー名を取得
			String userName  = userInfoOnSession.getUserName();

			//HTML文書（回答入力画面）の出力
			out.println("<html>                                                                                  ");
			out.println("<head>                                                                                  ");
			out.println("  <title>回答入力</title>                                                               ");
			out.println("</head>                                                                                 ");
			out.println("<body>                                                                                  ");
			out.println("  <h2>わんちゃん暮らし改善アンケートフォーム</h2>                                       ");
			out.println("  <form action=\"SaveSurvey\" method=\"post\">                                          ");
			out.println("  <p>ようこそ <b>" + userName + "</b> さん</p>                                          ");
			out.println("    </p>                                                                                ");
			out.println("    <p>年齢：                                                                           ");
			out.println("      <input type=\"number\" name=\"AGE\" maxlength = \"3\">                            ");
			out.println("    </p>                                                                                ");
			out.println("    <p>性別：                                                                           ");
			out.println("      <input type=\"radio\" name=\"SEX\" value=\"1\" checked>オス                       ");
			out.println("      <input type=\"radio\" name=\"SEX\" value=\"2\">メス                               ");
			out.println("    </p>                                                                                ");
			out.println("    <p> 満足度：                                                                        ");
			out.println("      <select name=\"SATISFACTION_LEVEL\">                                              ");
			out.println("        <option value=\"5\">とても満足</option>                                         ");
			out.println("        <option value=\"4\">満足      </option>                                         ");
			out.println("        <option value=\"3\">普通      </option>                                         ");
			out.println("        <option value=\"2\">不満      </option>                                         ");
			out.println("        <option value=\"1\">とても不満</option>                                         ");
			out.println("      </select>                                                                         ");
			out.println("    </p>                                                                                ");
			out.println("    <p>飼い主へのご意見・ご感想をご記入ください：<br>                                   ");
			out.println("      <textarea name=\"MESSAGE\" rows=\"4\" cols=\"50\" maxlength = \"250\"></textarea> ");
			out.println("    </p>                                                                                ");
			out.println("    <input type=\"submit\" value=\"回答する\">                        ");
			out.println("  </form>                                                                               ");
			out.println("  <br>                                                                                  ");
			out.println("  <a href=\"ShowAllSurvey\">回答一覧画面へ</a>                                          ");
			out.println("  <a href=\"ExecuteLogout\">ログアウトする</a>    "                                      );
			out.println("</body>                                                                                 ");
			out.println("</html>                                                                                 ");
			
		} else {
			//未ログイン：ログイン画面へ転送
			response.sendRedirect("Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
