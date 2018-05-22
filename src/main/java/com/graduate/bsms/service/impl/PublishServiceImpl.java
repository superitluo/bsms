package com.graduate.bsms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.bsms.mapper.PublishMapper;
import com.graduate.bsms.pojo.Publish;
import com.graduate.bsms.pojo.Page;
import com.graduate.bsms.service.PublishService;

@Service
public class PublishServiceImpl implements PublishService {
    @Autowired
    PublishMapper publishMapper;

    @Override
    public List<Publish> queryUsablePublishList(Page page) {
        return publishMapper.queryUsablePublishList(page);
    }

    @Override
    public List<Publish> queryUnusablePublishList(Page page) {
        return publishMapper.queryUnusablePublishList(page);
    }

    @Override
    public void removePublishById(int publishId) {
        publishMapper.removePublishById(publishId);
    }

    @Override
    public void addPublish(String publishName) {
        publishMapper.addPublish(new Publish(0, null, publishName, null, 0));
    }

    @Override
    public int queryUsablePublishTotal() {
        return publishMapper.queryUsablePublishTotal();
    }

    @Override
    public int queryUnusablePublishTotal() {
        return publishMapper.queryUnusablePublishTotal();
    }

    @Override
    public void removeAllPublish() {
        publishMapper.removeAllPublish();
    }

    @Override
    public void addAllPublish() {
        publishMapper.addAllPublish();
    }

    @Override
    public void setToUsable(String publishIds) {
        String[] ids2 = publishIds.split(",");
        for (int i = 0; i < ids2.length; i++) {
            publishMapper.setToUsable(Integer.parseInt(ids2[i]));
        }
    }

    @Override
    public void setToUnusable(String publishIds) {
        String[] ids2 = publishIds.split(",");
        for (int i = 0; i < ids2.length; i++) {
            publishMapper.setToUnusable(Integer.parseInt(ids2[i]));
        }
    }

    @Override
    public List<Publish> queryAllPublish() {
        return publishMapper.queryAllPublish();
    }


}
