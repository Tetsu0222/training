package work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**----------------------------------------------------------------------*
 *■■■ShowAllSurveyクラス■■■
 *概要：サーブレット
 *詳細：「survey」テーブルのデータを全件抽出して回答一覧画面を出力する。
 *----------------------------------------------------------------------**/
public class ShowAllSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowAllSurvey() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");

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

			//「survey」テーブルのデータを全件抽出
			List<SurveyDto> list  = new ArrayList<SurveyDto>();
			ShowAllSurveyBL logic = new ShowAllSurveyBL();
			list = logic.executeSelectSurvey();
	
			//HTML文書（回答一覧画面）の出力
			out.println(        "<html>                                         ");
			out.println(        "  <head>                                       ");
			out.println(        "    <title>回答一覧</title>                    ");
			out.println(        "  </head>                                      ");
			out.println(        "  <body>                                       ");
			out.println(        "    <h2>アンケート回答一覧</h2>                ");
			out.println(        "    <table class=\"surbey_list\" border=1>     ");
			out.println(        "      <tr bgcolor=\"#c0c0c0\">                 ");
			out.println(        "        <th>名前</th>                          ");
			out.println(        "        <th>年齢</th>                          ");
			out.println(        "        <th>性別</th>                          ");
			out.println(        "        <th>満足度</th>                        ");
			out.println(        "        <th>ご意見・ご感想</th>                ");
			out.println(        "        <th>回答時間</th>                      ");
			out.println(        "      </tr>                                    ");
	
			for (int i = 0; i < list.size(); i++) {
				SurveyDto dto = list.get(i);
				out.println(    "      <tr>                                     ");
				out.println(    "        <td>" + dto.getName() + "</td>"         );
				out.println(    "        <td>" + dto.getAge() + "</td>"          );
				if (dto.getSex() == 1) {
					out.println("        <td>" + "オス" + "</td>"                );
				} else {
					out.println("        <td>" + "メス" + "</td>"                );
				}
				switch (dto.getSatisfactionLevel()) {
				case 1:
					out.println("        <td>" + "とても不満" + "</td>"          );
					break;
				case 2:
					out.println("        <td>" + "不満" + "</td>"                );
					break;
				case 3:
					out.println("        <td>" + "普通" + "</td>"                );
					break;
				case 4:
					out.println("        <td>" + "満足" + "</td>"                );
					break;
				case 5:
					out.println("        <td>" + "とても満足" + "</td>"          );
					break;
				}
	
				out.println(    "        <td>" + dto.getMessage() + "</td>"      );
				out.println(    "        <td>" + dto.getTime()    + "</td>"      );
				out.println(    "      </tr>                                    ");
			}
			out.println(        "    </table>                                   ");
			out.println(        "    <br>                                       ");
			out.println(        "    <a href=\"InputSurvey\">回答画面に戻る</a> ");
			out.println(        "  </body>                                      ");
			out.println(        "</html>                                        ");
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
