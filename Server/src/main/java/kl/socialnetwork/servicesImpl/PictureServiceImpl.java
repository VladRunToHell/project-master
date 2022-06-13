package kl.socialnetwork.servicesImpl;

import kl.socialnetwork.domain.entities.Picture;
import kl.socialnetwork.domain.entities.Role;
import kl.socialnetwork.domain.entities.User;
import kl.socialnetwork.domain.models.serviceModels.PictureServiceModel;
import kl.socialnetwork.repositories.PictureRepository;
import kl.socialnetwork.repositories.RoleRepository;
import kl.socialnetwork.repositories.UserRepository;

import kl.socialnetwork.services.*;
import kl.socialnetwork.utils.responseHandler.exceptions.*;
import kl.socialnetwork.validations.serviceValidation.services.PictureValidationService;
import kl.socialnetwork.validations.serviceValidation.services.UserValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static kl.socialnetwork.utils.constants.ResponseMessageConstants.SERVER_ERROR_MESSAGE;
import static kl.socialnetwork.utils.constants.ResponseMessageConstants.UNAUTHORIZED_SERVER_ERROR_MESSAGE;

@Service
@Transactional
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;
    private final UserValidationService userValidation;
    private final PictureValidationService pictureValidation;


    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, UserRepository userRepository,
                              RoleRepository roleRepository, ModelMapper modelMapper, UserValidationService userValidation, PictureValidationService pictureValidation) {
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

        this.modelMapper = modelMapper;
        this.userValidation = userValidation;
        this.pictureValidation = pictureValidation;

    }

    @Override
    public boolean addPicture(String loggedInUserId, MultipartFile file) throws Exception {
        User user = this.userRepository.findById(loggedInUserId).orElse(null);

        if (!userValidation.isValid(user)) {
            throw new Exception(SERVER_ERROR_MESSAGE);
        }

        Picture picture = new Picture();
        //picture.setImageUrl(uploadMap.get("url").toString());
        picture.setUser(user);
        picture.setTime(LocalDateTime.now().toInstant(ZoneOffset.MAX));

        return this.pictureRepository.save(picture) != null;
    }

    @Override
    public List<PictureServiceModel> getAllPicturesByUserId(String userId) {
        return null;
    }

    /*@Override
    public List<PictureServiceModel> getAllPicturesByUserId(String userId) {
        List<Picture> pictureList = this.pictureRepository.findAllByUserId(userId);

        return pictureList
                .stream()
                .map(picture -> this.modelMapper
                        .map(picture, PictureServiceModel))
                .collect(Collectors.toList());
    }*/

    @Override
    public boolean deletePicture(String loggedInUserId, String photoToRemoveId) throws Exception {
        User loggedInUser = this.userRepository.findById(loggedInUserId).orElse(null);
        Picture photoToRemove = this.pictureRepository.findById(photoToRemoveId).orElse(null);

        if (!userValidation.isValid(loggedInUser) || !pictureValidation.isValid(photoToRemove)) {
            throw new Exception(SERVER_ERROR_MESSAGE);
        }


        Role rootRole = this.roleRepository.findByAuthority("ROOT");
        //boolean hasRootAuthority = loggedInUser.getAuthorities().contains(rootRole);
        boolean pictureOwnershipCheck = photoToRemove.getUser().getId().equals(loggedInUserId);
        return false;
    }
}
