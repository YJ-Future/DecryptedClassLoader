package gloryzyf.classloader;

import gloryzyf.util.EnDecrptUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 一个简单的解密类加载器
 * @author YU
 *
 */
public class DecryptedClassLoader extends ClassLoader {
	
	private String classPath;
	
	public DecryptedClassLoader(String classPath) {
		this.classPath=classPath;
	}
	
	@Override
	protected Class<?> findClass(String className) throws ClassNotFoundException {
		try {
			byte []data=getData(className);
			if(data==null){
				throw new ClassNotFoundException();
			}else{
				return defineClass(className,data,0,data.length);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.findClass(className);//这里直接调用的就是ClassLoader的findClass方法直接抛出ClassNotFoundException
		//调用到自己定义的findClass的时候，说明了parent的findClass方法都已经调用过了  parent和super不是一回事
	}
	
	private byte[] getData(String className) throws IOException{
		String path=classPath+File.separatorChar+className.replace('.', File.separatorChar)+".class";
		InputStream is=new FileInputStream(path);
		ByteArrayOutputStream stream=new ByteArrayOutputStream();
		EnDecrptUtils.EnDecrpt(is, stream);//解密
		return	stream.toByteArray();
	}
	
	
	
	
	
	
	
	
	
}
