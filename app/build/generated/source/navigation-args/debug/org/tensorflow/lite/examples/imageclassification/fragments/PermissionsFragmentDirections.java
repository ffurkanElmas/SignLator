package org.tensorflow.lite.examples.imageclassification.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import org.tensorflow.lite.examples.imageclassification.R;

public class PermissionsFragmentDirections {
  private PermissionsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionPermissionsToCamera() {
    return new ActionOnlyNavDirections(R.id.action_permissions_to_camera);
  }
}
