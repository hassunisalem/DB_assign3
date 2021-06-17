package dk.dd.j4neo.service;

import dk.dd.j4neo.model.User;
import dk.dd.j4neo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class GraphVisual
{
        private final static Logger LOG = LoggerFactory.getLogger(GraphVisual.class);


        private Map<String, Object> toD3Format(Collection<User> users)
        {
            List<Map<String, Object>> nodes = new ArrayList<>();
            List<Map<String, Object>> rels = new ArrayList<>();
            int i = 0;
            Iterator<User> result = users.iterator();
            while (result.hasNext())
            {
                User user = result.next();
              //  nodes.add("name", user.getName());

            }
            return map("nodes", nodes, "links", rels);
        }

        private Map<String, Object> map(String key1, Object value1, String key2, Object value2)
        {
            Map<String, Object> result = new HashMap<String, Object>(2);
            result.put(key1, value1);
            result.put(key2, value2);
            return result;
        }

        @Transactional(readOnly = true)
        public User findByName(String name) {
            User result = UserRepository.getUserByName(name);
            return result;
        }


}
