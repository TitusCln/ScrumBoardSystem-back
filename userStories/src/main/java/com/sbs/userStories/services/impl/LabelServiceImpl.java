package com.sbs.userStories.services.impl;

import com.sbs.contracts.dto.LabelDTO;
import com.sbs.userStories.models.Label;
import com.sbs.userStories.models.LabelRepository;
import com.sbs.userStories.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelRepository labelRepository;

    @Override
    public Iterable<LabelDTO> getAll() {
        return StreamSupport.stream(labelRepository.findAll().spliterator(), true)
                .map(Label::toDTO)
                .collect(Collectors.toList());
    }
}
