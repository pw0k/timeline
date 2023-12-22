package pw.timeline.model.post;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

//        SELECT
//        'USER' AS postType,
//        u.name AS postOwnerName,
//                p.id AS postId, -- Replace with the actual primary key of the post table
//        p.created_at AS postCreatedAt,
//                p.title AS postTitle,
//        p.description AS postDescription
//                FROM
//        follow f
//        JOIN tm_user u ON f.user_id = u.id
//        LEFT JOIN post p ON u.id = p.user_id
//        WHERE
//        f.follower_user_id = :userId
//
//                UNION
//
//        SELECT
//        'GROUP' AS postType,
//        g.groupname AS postOwnerName,
//                p.id AS postId, -- Replace with the actual primary key of the post table
//        p.created_at AS postCreatedAt,
//                p.title AS postTitle,
//        p.description AS postDescription
//                FROM
//        follow f
//        JOIN tm_group g ON f.group_id = g.id
//        LEFT JOIN post p ON g.id = p.group_id
//        WHERE
//        f.follower_user_id = :userId
//        ORDER BY
//        postCreatedAt DESC;

@Repository
@RequiredArgsConstructor
//todo jdbc template ??
public class TimelineCustomRepo {

    private final EntityManager entityManager;

    public List<Object[]> findPostsByFollowerId(Long userId) {
        String sql = """
                SELECT 
                    u.name, 
                    g.groupname, 
                    p.created_at AS createdAt, 
                    p.title AS postTitle, 
                    p.description AS postDescription
                FROM follow f 
                    LEFT JOIN tm_user u ON f.followee_user_id = u.id 
                    LEFT JOIN tm_group g ON f.followee_group_id = g.id 
                    LEFT JOIN post p ON (g.id = p.group_id OR u.id = p.user_id)                                    
                WHERE f.follower_id = :userId 
                ORDER BY p.created_at DESC
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("userId", userId);

        return query.getResultList();
    }

}
