package com.tdd.progress

import com.tdd.domain.entity.response.progress.ProgressStepItem
import com.tdd.ui.base.PageState

data class ProgressPageState(
    val progressStep: List<ProgressStepItem> = emptyList(),
) : PageState