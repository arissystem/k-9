package app.k9mail.feature.navigation.drawer.ui.folder

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import app.k9mail.core.mail.folder.api.FolderType
import app.k9mail.core.ui.compose.designsystem.atom.icon.Icon
import app.k9mail.core.ui.compose.designsystem.atom.icon.Icons
import app.k9mail.core.ui.compose.designsystem.organism.drawer.NavigationDrawerItem
import app.k9mail.feature.navigation.drawer.domain.entity.DisplayAccountFolder

@Composable
fun FolderListItem(
    displayFolder: DisplayAccountFolder,
    selected: Boolean,
    onClick: (DisplayAccountFolder) -> Unit,
    showStarredCount: Boolean,
    modifier: Modifier = Modifier,
) {
    NavigationDrawerItem(
        label = displayFolder.folder.name,
        selected = selected,
        onClick = { onClick(displayFolder) },
        modifier = modifier,
        icon = {
            Icon(
                imageVector = mapFolderIcon(displayFolder.folder.type),
            )
        },
        badge = {
            FolderListItemBadge(
                unreadCount = displayFolder.unreadMessageCount,
                starredCount = displayFolder.starredMessageCount,
                showStarredCount = showStarredCount,
            )
        },
    )
}

private fun mapFolderIcon(type: FolderType): ImageVector {
    return when (type) {
        FolderType.INBOX -> Icons.Outlined.Inbox
        FolderType.OUTBOX -> Icons.Outlined.Outbox
        FolderType.SENT -> Icons.Outlined.Send
        FolderType.TRASH -> Icons.Outlined.Delete
        FolderType.DRAFTS -> Icons.Outlined.Drafts
        FolderType.ARCHIVE -> Icons.Outlined.Archive
        FolderType.SPAM -> Icons.Outlined.Report
        FolderType.REGULAR -> Icons.Outlined.Folder
    }
}
