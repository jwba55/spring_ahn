package kr.co.kopo.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileuploadUtil {
	private final String path = "c:/upload";
	
	public String saveFile(MultipartFile file, Model model) throws Exception{
		String uuid = UUID.randomUUID().toString();	
		try {
			
            // 파일 저장
            File destinationFile = new File(path + "/" + uuid +"_"+ file.getOriginalFilename());
            file.transferTo(destinationFile);

            model.addAttribute("filePath", destinationFile.getAbsolutePath());
            //저장 경로 반환
            String filepath = destinationFile.getAbsolutePath();	//상세 정보 필요
            filepath = filepath.replace("\\", "/"); // 백슬래시를 슬래시로 변환
    		return filepath;//서비스로 반환된 것을 저장 필요

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
