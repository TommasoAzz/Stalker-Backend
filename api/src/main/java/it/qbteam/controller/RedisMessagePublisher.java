package it.qbteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class RedisMessagePublisher implements MessagePublisher {
    @Autowired @Qualifier("movement")
    private RedisTemplate<String, String> redisTemplate;
    
    @Autowired @Qualifier("organizationMovement")
    private ChannelTopic topic;

    public RedisMessagePublisher() {
    }

    public RedisMessagePublisher(final RedisTemplate<String, String> redisTemplate2, final ChannelTopic topic) {
        this.redisTemplate = redisTemplate2;
        this.topic = topic;
    }

    public void publish(final String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}