package com.example.startit.controller;

import com.example.startit.entity.ChatEntity;
import com.example.startit.entity.MessageEntity;
import com.example.startit.entity.UserEntity;
import com.example.startit.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/create_chat")
    public ResponseEntity createChat(@RequestBody ChatEntity chat) {
        try {
            ChatEntity chatEnt = chatService.createChat(chat);
            return ResponseEntity.ok(chatEnt);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка при создании чата.");
        }
    }

    @PostMapping("/send_message")
    public ResponseEntity sendMessage(@RequestBody MessageEntity message) {
        try {
            return ResponseEntity.ok(chatService.sendMessage(message));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка при отправке сообщения.");
        }
    }

    @GetMapping("/get_messages")
    public ResponseEntity getMessages(@RequestParam("chat_id") Long chatId) {
        try {
            MessageEntity[] messages = chatService.getMessages(chatId);
            return ResponseEntity.ok(messages);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка при отправке сообщения.");
        }
    }

    @GetMapping("/get_chats")
    public ResponseEntity getChats(@RequestParam("user_id") Long userId) {
        try {
            ChatEntity[] chats = chatService.getChats(userId);
            return ResponseEntity.ok(chats);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка при отправке сообщения.");
        }
    }
}
