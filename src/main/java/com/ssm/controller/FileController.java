package com.ssm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ssm.common.Constant;

@Controller
@RequestMapping("/file")
public class FileController {

	/**
	 * 单文件上传
	 * @param file 上传的文件
	 * @param model 回传的model
	 */
	@RequestMapping("/fileupload1")
	public String fileUploadOne(@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request,ModelMap model){
		
		//文件重命名
		String filename = file.getOriginalFilename();
		String newFileName = UUID.randomUUID() + filename;
		
		//上传路径
		ServletContext sc = request.getSession().getServletContext();
		String path = sc.getRealPath("/upload") + "/";
		
		File f = new File(path);
		if(!f.exists()){
			f.mkdirs(); //文件夹不存在，新建文件夹
		}
		if(!file.isEmpty()){ //文件非空
			try {
				FileOutputStream fos = new FileOutputStream(path+newFileName);
				InputStream in = file.getInputStream();
				int b = 0;
				while((b = in.read()) != -1){
					fos.write(b);
				}
				fos.close();
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("filepath", Constant.filepath+newFileName);
		return "/fileupload/file1";
	}
	
	/**
	 * 多文件上传
	 * @param file 上传的文件
	 * @param model 回传的model
	 */
	@RequestMapping("/fileupload2")
	public String fileUploadMore(@RequestParam("file") CommonsMultipartFile file[],
			HttpServletRequest request,ModelMap model){
		
		List<String> list = new ArrayList<String>();
		
		ServletContext sc = request.getSession().getServletContext();
		String path = sc.getRealPath("/upload") + "/";
		
		File f = new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		//循环上传
		for(int i = 0;i < file.length;i++){
			String filename = file[i].getOriginalFilename();
			String newFilename = UUID.randomUUID() + filename;
			
			if(!file[i].isEmpty()){
				try {
					FileOutputStream fos = new FileOutputStream(path+newFilename);
					InputStream in = file[i].getInputStream();
					int b = 0;
					while((b = in.read()) != -1){
						fos.write(b);
					}
					fos.close();
					in.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			list.add(Constant.filepath+newFilename);
		}
		model.addAttribute("filelist", list);
		return "/fileupload/file2";
	}

	/**
	 * 文件下载
	 */
	@RequestMapping("/fileDown")
	public void fileDown(HttpServletRequest request,HttpServletResponse response){
		String filename = request.getParameter("filename");
		
		try {
			filename = new String(filename.getBytes("ISO8859-1"),"utf-8");
			ServletContext sc = request.getSession().getServletContext();
			String uploadPath = sc.getRealPath("/upload") + "/";
			File file = new File(uploadPath + "\\" + filename);
			
			if(!file.exists()){
				return;
			}
			String realname = filename.substring(filename.indexOf("_") + 1);
			response.setHeader("content-disposition", "attachment;filename=" 
									+ URLEncoder.encode(realname, "UTF-8"));
			FileInputStream fis = new FileInputStream(uploadPath + "\\" + filename);
			OutputStream out = response.getOutputStream();
			byte buffer[] = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer)) > 0){
				out.write(buffer, 0, len);
			}
			fis.close();
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/file1")
	public String toFile1(){
		return "/fileupload/file1";
	}
	
	@RequestMapping("/file2")
	public String toFile2(){
		return "/fileupload/file2";
	}
	
	@RequestMapping("/filelist")
	public String toFileList(HttpServletRequest request,HttpServletResponse response){
		
		ServletContext sc = request.getSession().getServletContext();
		
		String uploadPath = sc.getRealPath("/upload") + "/";
		
		Map<String,String> filesname = new HashMap<String,String>();
		
		listFileMap(new File(uploadPath),filesname);
		
		request.setAttribute("filelist", filesname);
		
		return "/fileupload/filelist";
	}
	
	//遍历文件夹下的文件
	public void listFileMap(File file,Map<String,String> map){
		if(file.exists()){
			File[] files = file.listFiles();
			if(null == files || files.length == 0){
				return;
			}else{
				for(File file2 : files){
					if(file2.isDirectory()){
						listFileMap(new File(file2.getAbsolutePath()),map);
					}else{
						map.put(file2.getName(), file2.getName());
					}
				}
			}
		}
	}
	
	
}
