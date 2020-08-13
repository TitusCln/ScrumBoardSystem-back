package userStories;

import com.sbs.dto.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import userStories.service.UserStoryService;

@RestController
public class Controller {

    @Autowired
    private UserStoryService userStoryService;

    @GetMapping(value = "/userstories", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UserStory> getAll(){
        return userStoryService.getAll();
    }

    @GetMapping(value = "/userstories/{userStoryId}")
    public UserStory get(@PathVariable Long userStoryId){
        return userStoryService.findById(userStoryId);
    }

    @PostMapping(value = "/userstories")
    public UserStory create(@RequestBody UserStory userStory){
        return userStoryService.create(userStory);
    }

    @PutMapping(value = "/userstories/{userStoryId}")
    public UserStory update(@RequestBody UserStory userStory, @PathVariable Long userStoryId) {
        return userStoryService.update(userStory, userStoryId);
    }

    @DeleteMapping(value = "/userstories/{userStoryId}")
    public void delete(@PathVariable Long userStoryId) {
        userStoryService.deleteById(userStoryId);
    }

}
