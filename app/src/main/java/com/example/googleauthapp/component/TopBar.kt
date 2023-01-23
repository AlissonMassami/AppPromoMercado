
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun TopBar(onclickPesquisar: () -> Unit, onClickAdd: () -> Unit, onClickHome: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Promo App!")
        },
        actions = {
            // search icon
            TopAppBarActionButton(
                imageVector = Icons.Outlined.Search,
                description = "Search",
                onClick = onclickPesquisar
            )

            // lock icon
            TopAppBarActionButton(
                imageVector = Icons.Outlined.Add,
                description = "Add",
                onClick = onClickAdd
            )

            TopAppBarActionButton(
                imageVector = Icons.Outlined.Home,
                description = "Home",
                onClick = onClickHome
            )

        }
    )
}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}