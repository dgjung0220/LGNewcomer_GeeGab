package DBManager.sample.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import DBManager.Web.vo.Menu;

@Controller
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/sample/openSampleList.do")
	public ModelAndView openSampleList(Map<String,Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("");
		log.debug("인터셉터 테스트");
		
		return mv;
	}
	
	@RequestMapping(value="/insertMenu.do")
	@ResponseBody
	public void insertMenu(String nameOfMenu, int calOfMenu, @RequestParam("file")MultipartFile file) {
		byte[] pictureOfMenu = null;
		
		try {
			pictureOfMenu = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//new Menu(nameOfMenu, Integer.parseInt(calOfMenu), pictureOfMenu);
		System.out.println(nameOfMenu);
		System.out.println(calOfMenu);
		System.out.println(pictureOfMenu);
	}
}
