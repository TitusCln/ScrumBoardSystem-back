package com.sbs.userStories.services;

import com.sbs.contracts.dto.LabelDTO;

public interface LabelService {

    Iterable<LabelDTO> getAll();

}
