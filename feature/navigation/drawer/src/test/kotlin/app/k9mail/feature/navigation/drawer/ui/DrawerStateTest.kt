package app.k9mail.feature.navigation.drawer.ui

import app.k9mail.feature.navigation.drawer.domain.entity.DrawerConfig
import app.k9mail.feature.navigation.drawer.ui.DrawerContract.State
import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.collections.immutable.persistentListOf
import org.junit.Test

class DrawerStateTest {

    @Test
    fun `should set default values`() {
        val state = State()

        assertThat(state).isEqualTo(
            State(
                config = DrawerConfig(
                    showUnifiedInbox = false,
                    showStarredCount = false,
                ),
                accounts = persistentListOf(),
                selectedAccount = null,
                folders = persistentListOf(),
                selectedFolder = null,
                showAccountSelector = false,
                isLoading = false,
            ),
        )
    }
}
