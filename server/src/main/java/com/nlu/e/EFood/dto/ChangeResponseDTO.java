package com.nlu.e.EFood.dto;



public class ChangeResponseDTO {
    private String message;
    private boolean success;
    private AccountDTO user;

    public ChangeResponseDTO(String message, boolean success, AccountDTO user) {
        this.message = message;
        this.success = success;
        this.user = user;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public AccountDTO getUser() {
        return user;
    }

    public void setUser(AccountDTO user) {
        this.user = user;
    }
}
