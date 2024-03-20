package com.vtnlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.vtnlab.bootcamp.bootcampsbforum.dto.request.UserPostRequestDTO;
import com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtnlab.bootcamp.bootcampsbforum.infra.BcUtil;
import com.vtnlab.bootcamp.bootcampsbforum.infra.JPHClientException;
import com.vtnlab.bootcamp.bootcampsbforum.infra.ResourceNotFound;
import com.vtnlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtnlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtnlab.bootcamp.bootcampsbforum.mapper.UserMapper;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Album;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Photo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Todo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtnlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtnlab.bootcamp.bootcampsbforum.service.UserService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class UserJsonPlaceHolder implements UserService {

    @Value(value="${api.jph.domain}")
    private String domain;

    @Value(value="${api.jph.endpoints.user}")
    private String userEndpoint;

    @Value(value="${api.jph.endpoints.post}")
    private String postEndpoint;

    @Value(value="${api.jph.endpoints.album}")
    private String albumEndpoint;

    @Value(value="${api.jph.endpoints.todo}")
    private String todoEndpoint;

    @Value(value="${api.jph.endpoints.comment}")
    private String commentEndpoint;

    @Value(value="${api.jph.endpoints.photo}")
    private String photoEndpoint;

    @Autowired
    private RestTemplate restTemplate; // refer to config/AppConfig @Bean restTemplate

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("null")
    @Override
    public List<User> getUsers() {
        // RestTemplate  restTemplate = new RestTemplate();
        String userUrl = BcUtil.url(Scheme.HTTPS,domain, userEndpoint);
        User[] users = restTemplate.getForObject(userUrl,User[].class);
        return Arrays.stream(users).collect(Collectors.toList());
    }

    @Override
    public User getUser(int index) {
        Optional<User> userPostDTO = this.getUsers().stream()
                                        .filter(e->e.getId()==index)
                                        .findFirst();
        if (userPostDTO.isPresent()) 
            return userPostDTO.get();
        
        throw new ResourceNotFound(Syscode.NOTFOUND);
    }

    @SuppressWarnings("null")
    @Override
    public List<Post> getPosts() {
        // RestTemplate  restTemplate = new RestTemplate();
        String postUrl = BcUtil.url(Scheme.HTTPS,domain, postEndpoint);
        // Post[] posts = restTemplate.getForObject(postUrl,Post[].class);
        // return Arrays.stream(posts).collect(Collectors.toList());
        try {
            Post[] posts = restTemplate.getForObject(postUrl,Post[].class);
            return Arrays.stream(posts).collect(Collectors.toList());
        } catch (RestClientException e) {
        //    return new ArrayList<>();
            throw new JPHClientException(Syscode.JPHCLIENT_NOT_AVAILABLE);
        }
    }

    @SuppressWarnings("null")
    @Override
    public List<Album> getAlbums() {
        // RestTemplate  restTemplate = new RestTemplate();
        String albumUrl = BcUtil.url(Scheme.HTTPS,domain, albumEndpoint);
        Album[] albums = restTemplate.getForObject(albumUrl,Album[].class);
        return Arrays.stream(albums).collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public List<Todo> getTodos() {
        // RestTemplate  restTemplate = new RestTemplate();
        String todoUrl = BcUtil.url(Scheme.HTTPS,domain, todoEndpoint);
        Todo[] todos = restTemplate.getForObject(todoUrl,Todo[].class);
        return Arrays.stream(todos).collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public List<Comment> getComments() {
        // RestTemplate  restTemplate = new RestTemplate();
        String commentUrl = BcUtil.url(Scheme.HTTPS,domain, commentEndpoint);
        Comment[] comments = restTemplate.getForObject(commentUrl,Comment[].class);
        return Arrays.stream(comments).collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public List<Photo> getPhotos() {
        // RestTemplate  restTemplate = new RestTemplate();
        String photoUrl = BcUtil.url(Scheme.HTTPS,domain, photoEndpoint);
        Photo[] photos = restTemplate.getForObject(photoUrl,Photo[].class);
        return Arrays.stream(photos).collect(Collectors.toList());
    }
    // com.vtnlab.bootcamp.bootcampsbforum.service.impl

    // @Override
    // public com.vtnlab.bootcamp.bootcampsbforum.entity.User getFindByUsername(String username) {
    //     return userRepository.findByUsername(username);
    // }
    @Override
    public List<UserEntity> getAllByEmailOrPhone(String email, String phone, Sort sort){
        return userRepository.findAllByEmailOrPhone(email, phone, sort);
    }
    
    public List<UserEntity> getAllByEmailOrPhone(String email, String phone){
        Sort sort = Sort.by("email").ascending().and(Sort.by("phone").ascending());
        return userRepository.findAllByEmailOrPhone(email, phone, sort);
    }

    @Override
    public Long countUserByName(String prefix) {
        return userRepository.countUserByNameStartWith(prefix);
    }

    @Override
    public List<UserEntity> getUserByAddrLatGreaterThan(Double latitute) {
        return userRepository.findAllByAddrLatGreaterThan(latitute);
    }

    @Override
    @Transactional // ensure whole block success as success transaction
    public void updateUserEmail(Long id, String email) {
         userRepository.updateUser(id, email);
    }

    @Override
    @Transactional
    public UserEntity updateUserById(Long userId, com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity newUser) {
        UserEntity oldUser = entityManager.find(com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity.class, userId);

        //select 
        oldUser.setId(newUser.getId());
        oldUser.setName(newUser.getName());
        oldUser.setUsername(newUser.getUsername());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPhone(newUser.getPhone());
        oldUser.setWebsite(newUser.getWebsite());
        oldUser.setStreet(newUser.getStreet());
        oldUser.setSuite(newUser.getSuite());
        oldUser.setCity(newUser.getCity());
        oldUser.setZipcode(newUser.getZipcode());
        oldUser.setAddrLat(newUser.getAddrLat());
        oldUser.setAddrLng(newUser.getAddrLng());
        oldUser.setCName(newUser.getCName());
        oldUser.setCCatchPhrase(newUser.getCCatchPhrase());
        oldUser.setCBusService(newUser.getCBusService());

        entityManager.merge(oldUser);
        return oldUser;
    }

    @Override
    @Transactional
    public UserEntity save(UserPostRequestDTO userRequestDTO) {
        UserEntity userEntity = userMapper.mapEntity(userRequestDTO);
        return userRepository.save(userEntity);
    }



    
}
