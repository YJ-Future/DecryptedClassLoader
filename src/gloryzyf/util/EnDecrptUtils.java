package gloryzyf.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 加密解密的工具类
 * @author YU
 *
 */
public class EnDecrptUtils {
	
	/**
	 * 使用异或方法来加密解密 
	 * @param in
	 * @param out
	 * @throws IOException 
	 */
	public static void EnDecrpt(InputStream in,OutputStream out) throws IOException{
		int b=-1;
		while((b=in.read())!=-1){
			out.write(b^0xff);
		}
	}
}
