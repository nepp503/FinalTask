package com.siniak.finaltask.service;

import com.siniak.finaltask.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.*;

/**
 * Service for image loading
 * @author Vitali Siniak
 */

public class LoadImageService extends AbstractService{

    /**
     * Loads image and returns path to it
     * @param parts
     * @see Collection
     * @see Part
     * @param applicationDir - application directory
     * @return image path
     * @throws ServiceException
     */
    public String loadImage(Collection<Part> parts, String applicationDir) throws ServiceException {
        String uploadFileDir = applicationDir + UPLOAD_DIR + SEPARATOR;
        File fileSaveDir = new File(uploadFileDir);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        String fullFileName = null;
        String filePath = null;
        try {
            for(Part part : parts) {
                if (part.getSubmittedFileName() != null) {
                    String path = part.getSubmittedFileName();
                    if (path.lastIndexOf(".png") > 0 || path.lastIndexOf(".jpg") > 0) {
                        String randFilename = UUID.randomUUID()+path.substring(path.lastIndexOf("."));
                        fullFileName = uploadFileDir + randFilename;
                        filePath = UPLOAD_DIR + SEPARATOR + randFilename;
                        part.write(fullFileName);
                    }
                }
            }
        } catch (IOException e) {
            throw new ServiceException(FILE_DOWNLOAD_ERROR_MSG, e);
        }
        return filePath;
    }
}
