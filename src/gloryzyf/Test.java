package gloryzyf;

import gloryzyf.classloader.DecryptedClassLoader;
import gloryzyf.util.EnDecrptUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//把编译出来的User.class文件拷贝到指定的类加载路径  我放到了D:\\classpath下
		//先加密一下 classpath下的User.class文件
		//encrpt("D:\\User.class","D:\\classpath\\User.class");
		DecryptedClassLoader classLoader=new DecryptedClassLoader("D:\\classpath");
		Class c=classLoader.loadClass("User");
		if(c!=null)
			System.out.println(c);//输出class User 加载成功 使用 java Decompiler无法打开加密后的User.class
	}
	
	private static void encrpt(String srcPath,String desPath) throws IOException{
		FileInputStream fis=new FileInputStream(new File(srcPath));
		FileOutputStream fos=new FileOutputStream(new File(desPath));
		EnDecrptUtils.EnDecrpt(fis,fos);
		fis.close();
		fos.close();
	}
}
