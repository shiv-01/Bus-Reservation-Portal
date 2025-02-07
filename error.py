import sqlite3

# 🚨 Hardcoded credentials (vulnerability)
DATABASE_USER = "admin"
DATABASE_PASS = "password123"

def connect_db():
    # 🚨 Using hardcoded credentials (should use environment variables)
    conn = sqlite3.connect("example.db")
    return conn

def get_user_data(user_id):
    conn = connect_db()
    cursor = conn.cursor()

    # 🚨 SQL Injection vulnerability: Directly concatenating user input into SQL query
    query = f"SELECT * FROM users WHERE id = {user_id}"  # ❌ UNSAFE!
    cursor.execute(query)  # This allows attackers to manipulate queries
    result = cursor.fetchall()
    conn.close()
    return result

def get_user_secure(user_id):
    conn = connect_db()
    cursor = conn.cursor()

    # ✅ This is the secure way (parameterized query)
    query = "SELECT * FROM users WHERE id = ?"
    cursor.execute(query, (user_id,))
    result = cursor.fetchall()
    conn.close()
    return result

# 🚨 Simulated user input that an attacker might use
user_input = "105 OR 1=1"  # Attacker tries to get all users
data = get_user_data(user_input)
print("🚨 Insecure Query Result:", data)

# ✅ Secure Query Example
secure_data = get_user_secure("105")
print("✅ Secure Query Result:", secure_data)
