package testSample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sample_Main extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	public Sample_Main(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//文字コードを設定
		response.setContentType("text/html;charset=UTF-8");
		
		//HTML出力ストリームを生成
		PrintWriter out = response.getWriter();
		
		//HTML文書を生成して出力
		Stream <String> st = Stream.of( "<html>" , 
											"<head>" , 
												"<title>番号検索</title>" ,
											"</head>" , 
												"<body>" , 
													"<h2>番号検索フォーム</h2>" , 
														"<form action=\"Inspection\" method=\"post\">" ,
															"<P>",
																"ハイフンを省略しないで番号を入力してください。" ,
															"</P>",
															"<p>番号：",
																"<input type=\"text\" ID=\"ID\" maxlength = \"20\">" ,
															"</p>" ,
															"<p>",
																"&nbsp;",
															"</p> ",
															"<input type=\"submit\" value=\"回答する\">",
														"</form>",
												"</body>",
										"</html>");
		st.forEach( s -> out.println(s));
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
