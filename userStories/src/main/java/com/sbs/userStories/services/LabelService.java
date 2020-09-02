package com.sbs.userStories.services;

import com.sbs.contracts.dto.LabelDTO;

public interface LabelService {

    /**
     * Gets all the labels saved
     *
     * @return all the labelDTO objects saved
     */
    Iterable<LabelDTO> getAll();

}
