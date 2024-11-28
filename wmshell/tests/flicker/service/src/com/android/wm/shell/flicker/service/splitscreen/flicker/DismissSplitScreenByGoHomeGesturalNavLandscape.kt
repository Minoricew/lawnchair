/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.wm.shell.flicker.service.splitscreen.flicker

import android.tools.Rotation
import android.tools.flicker.FlickerConfig
import android.tools.flicker.annotation.ExpectedScenarios
import android.tools.flicker.annotation.FlickerConfigProvider
import android.tools.flicker.config.FlickerConfig
import android.tools.flicker.config.FlickerServiceConfig
import android.tools.flicker.junit.FlickerServiceJUnit4ClassRunner
import com.android.wm.shell.flicker.service.splitscreen.scenarios.DismissSplitScreenByGoHome
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(FlickerServiceJUnit4ClassRunner::class)
class DismissSplitScreenByGoHomeGesturalNavLandscape :
    DismissSplitScreenByGoHome(Rotation.ROTATION_90) {

    @ExpectedScenarios(["APP_CLOSE_TO_HOME"]) // SPLIT_SCREEN_EXIT not yet tagged here (b/301222449)
    @Test
    override fun dismissSplitScreenByGoHome() = super.dismissSplitScreenByGoHome()

    companion object {
        @JvmStatic
        @FlickerConfigProvider
        fun flickerConfigProvider(): FlickerConfig =
            FlickerConfig().use(FlickerServiceConfig.DEFAULT)
    }
}