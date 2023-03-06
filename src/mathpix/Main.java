package mathpix;

import java.sql.SQLException;

public class Main {

	public static void main(String args[]) {
		
//		ObjectMigration om = new ExistingObjectMigration();
//		om.setText("<img src=\"https://cdn.mathpix.com/snip/images/reiFKDEsIcl_aNxcL7QZGDEyTeYeGCwJd71Sn-2x8cU.original.fullsize.png\"> <br>\r\n"
//				+ "\r\n"
//				+ "위 그림과 같이 `$$\\angle \\mathrm{C}=90^{\\circ}$$` 이고,`$$\\overline{\\mathrm{AC}}=10 \\mathrm{~cm}$$` `$$\\mathrm{BC}=20 \\mathrm{~cm}$$` 인 직각삼각형 `$$\\mathrm{ABC}$$` 에서 `$$\\overl             ine{\\mathrm{AB}}$$` 위에 점 `$$\\mathrm{D}$$` 를 잡고, 점 `$$\\mathrm{D}$$` 에서 `$$\\overline{\\mathrm{BC}}, \\overline{\\mathrm{AC}}$$` 위에 내린 수선의 발을 각각 `$$\\mathrm{E}, \\mathrm             {F}$$` 라고 하자. `$$\\square \\mathrm{DECF}$$` 의 넓이가`$$18 \\mathrm{~cm}^{2}$$` 일 때, `$$\\overline{\\mathrm{DE}}$$` 의 길이를 구하시오. <br>\r\n"
//				+ "\r\n"
//				+ "(단, `$$\\overline{\\mathrm{EC}}~{<}~10 \\mathrm{~cm}$$` )");
//		om.execute();
		
		try {
			ObjectMigration om = new ExistingObjectMigration("quiz", "quiz_id", "contents");
			
			om.execute();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
