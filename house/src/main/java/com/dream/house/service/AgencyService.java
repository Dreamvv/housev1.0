package com.dream.house.service;

import com.dream.house.mapper.AgencyMapper;
import com.dream.house.model.Agency;
import com.dream.house.model.User;
import com.dream.house.page.PageData;
import com.dream.house.page.PageParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AgencyService {

    @Resource
    private AgencyMapper agencyMapper;

    @Value("${file.prefix}")
    private String imgPrefix;
    /**
     * 访问user表获取详情 添加用户头像
     *
     * @param userId
     * @return
     */
    public User getAgentDeail(Long userId){
        User user = new User();
        user.setId(userId);
        user.setType(2);
        List<User> list = agencyMapper.selectAgent(user, PageParams.build(1, 1));
        setImg(list);
        if (!list.isEmpty()) {
            User agent = list.get(0);
            //将经纪人关联的经纪机构也一并查询出来
            Agency agency = new Agency();
            agency.setId(agent.getAgencyId().intValue());
            List<Agency> agencies = agencyMapper.select(agency);
            if (!agencies.isEmpty()) {
                agent.setAgencyName(agencies.get(0).getName());
            }
            return agent;
        }
        return null;
    }


    private void setImg(List<User> list) {
        list.forEach(i -> i.setAvatar(imgPrefix + i.getAvatar()));

    }

    public PageData<User> getAllAgent(PageParams pageParams) {
        List<User> agents = agencyMapper.selectAgent(new User(), pageParams);
        setImg(agents);
        Long count = agencyMapper.selectAgentCount(new User());
        return PageData.buildPage(agents, count, pageParams.getPageSize(), pageParams.getPageNum());
    }

    public Agency getAgency(Integer id) {
        Agency agency = new Agency();
        agency.setId(id);
        List<Agency> agencies = agencyMapper.select(agency);
        if (agencies.isEmpty()) {
            return null;
        }
        return agencies.get(0);
    }

    public List<Agency> getAllAgency() {
        return agencyMapper.select(new Agency());
    }

    public int add(Agency agency) {
        return  agencyMapper.insert(agency);
    }

    public void sendMsg(User agent, String msg, String name, String email) {
        // TODO Auto-generated method stub

    }
}
