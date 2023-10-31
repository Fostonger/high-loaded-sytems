package com.example.startit.service;

import com.example.startit.entity.ChatEntity;
import com.example.startit.entity.ItemEntity;
import com.example.startit.entity.MessageEntity;
import com.example.startit.entity.UserEntity;
import com.example.startit.repository.ChatRepo;
import com.example.startit.repository.MessageRepo;
import com.example.startit.repository.UserRepo;
import com.example.startit.utils.ChatSpecifications;
import com.example.startit.utils.ItemSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatService {
    @Autowired
    ChatRepo chatRepo;
    @Autowired
    MessageRepo messageRepo;
    @Autowired
    UserRepo userRepo;

    public ChatEntity createChat(ChatEntity chat) {
        Optional<ChatEntity> oldChat = chatRepo.findByItem_IdAndCustomer_Id(
                chat.getItem().getId(),
                chat.getCustomer().getId()
        );
        return oldChat.orElseGet(() -> chatRepo.save(chat));
    }
    public MessageEntity sendMessage(MessageEntity message) {
        MessageEntity newMessage = new MessageEntity();
        Optional<ChatEntity> chat = chatRepo.findById(message.getChat().getId());
        Optional<UserEntity> user = userRepo.findById(message.getSender().getId());
        if (chat.isEmpty() || user.isEmpty()) {
            return newMessage;
        }
        newMessage.setSender(user.get());
        newMessage.setChat(chat.get());
        return messageRepo.save(newMessage);
    }

    public MessageEntity[] getMessages(Long chatId) {
        return messageRepo.findAllByChat_Id(chatId).toArray(new MessageEntity[0]);
    }

    public ChatEntity[] getChats(Long userId) {
        return chatRepo.findAll(ChatSpecifications.withUser(userId)).toArray( new ChatEntity[0]);
    }
}
