db.createUser(
        {
            user: "user",
            pwd: "user",
            roles: [
                {
                    role: "readWrite",
                    db: "simple-chat-db"
                }
            ]
        }
);

db.createCollection('user');

db.createCollection('room')
