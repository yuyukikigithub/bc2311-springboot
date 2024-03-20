package com.vtnlab.bootcamp.bootcampsbforum.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.request.UserPostRequestDTO;
import com.vtnlab.bootcamp.bootcampsbforum.entity.PostEntity;
import com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostMapper postMapper;

    public UserDTO map(User user){
        return this.modelMapper.map(user, UserDTO.class);
    }

    public UserEntity mapEntity(User user){
        return new UserEntity(null, 
        user.getName(), user.getUsername(), user.getEmail(), user.getPhone(), user.getWebsite(), user.getAddress().getStreet(), user.getAddress().getSuite(), user.getAddress().getCity(), user.getAddress().getZipcode(), user.getAddress().getGeo().getLat(), user.getAddress().getGeo().getLng(), user.getCompany().getName(), user.getCompany().getCatchPhrase(), user.getCompany().getBs(),null);
    }

    public UserEntity mapEntity(UserPostRequestDTO dto){
        UserEntity userEntity=new UserEntity(null, dto.getName(), //
                                dto.getUsername(), //
                                dto.getEmail(), //
                                dto.getPhone(), //
                                dto.getWebsite(), //
                                dto.getStreet(), //
                                dto.getSuite(), //
                                dto.getCity(), //
                                dto.getZipcode(), //
                                dto.getAddrLat(), //
                                dto.getAddrLong(), //
                                dto.getCompanyName(), //
                                dto.getCompanyCatchPhrase(), //
                                dto.getCompanyBusService(), //
                                null);

        List<PostEntity> postEntities = dto.getPosts().stream()
                                        .map(e->{
                                            PostEntity postEntity = postMapper.mapEntity(e);
                                            postEntity.setUser(userEntity);
                                            return postEntity;
                                        }).collect(Collectors.toList());
        userEntity.setPosts(postEntities); // One to Many
        return userEntity;
    }

    public UserPostDTO mapEntity(User user, List<Post> posts){
        List<PostDTO> postDTOs = posts.stream().filter(e-> user.getId()== e.getUserId())
                                    .map(e->{
                                        return PostDTO.builder()
                                                        .id(e.getId())
                                                        .title(e.getTitle())
                                                        .body(e.getBody())
                                                        .build();
                                    }).collect(Collectors.toList());
        return UserPostDTO.builder()
                            .id(user.getId())
                            .username(user.getUsername())
                            .email(user.getEmail())
                            .phone(user.getPhone())
                            .postDTOs(postDTOs)
                            .build();

    
    }
    
}
