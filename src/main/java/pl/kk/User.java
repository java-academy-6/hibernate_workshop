package pl.kk;

import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NamedQuery(name = "find_user_by_id", query = "SELECT id, login FROM user WHERE id = ?")
@NamedQuery(name = "find_all_users", query = "SELECT id, login FROM user")
@SQLInsert(sql = "INSERT INTO user (id, login) VALUES (?, ?)",
        check = ResultCheckStyle.COUNT
)
@SQLUpdate(
        sql = "UPDATE user SET login = ? where id = ?"
)
@SQLDelete(
        sql = "DELETE user WHERE id = ?"
)
@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String login;

    public User(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
