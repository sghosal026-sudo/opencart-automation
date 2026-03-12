package models;

public class User {
    
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private boolean newsletter;
    
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.password = builder.password;
        this.newsletter = builder.newsletter;
    }
    
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
    public boolean isNewsletter() { return newsletter; }
    
    public static class UserBuilder {
        
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String password;
        private boolean newsletter;
        
        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        
        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        
        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }
        
        public UserBuilder newsletter(boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }
        
        public User build() {
            return new User(this);
        }
    }
}