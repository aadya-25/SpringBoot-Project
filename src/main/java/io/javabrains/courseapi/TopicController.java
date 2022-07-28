package io.javabrains.courseapi;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TopicController {
     
    @Autowired                            //for  declaring dependency
    private TopicService topicService;

   
    @RequestMapping("/topics")              //by default get
    public List<Topic> getAllTopics()
    {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")            //{} indicates variable
    public Topic getTopic(@PathVariable String id)     // @ tells this id == that {id}
    {
        return topicService.getTopic(id);

    }

    @RequestMapping( value="/topics", method = RequestMethod.POST)             //for post
    public void addTopic(@RequestBody Topic topic)                                 //get req body and pass it to me as an instance
    {
        topicService.addTopic(topic);

    }

    @RequestMapping( value="/topics/{id}", method = RequestMethod.PUT)             //for post
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id)                                 //get req body and pass it to me as an instance
    {
        topicService.updateTopic(id,topic);

    }

    @RequestMapping( value="/topics/{id}", method = RequestMethod.DELETE)            //{} indicates variable
    public void deleteTopic(@PathVariable String id)     // @ tells this id == that {id}
    {
        topicService.deleteTopic(id);

    }



    


}
