// Generated by view binder compiler. Do not edit!
package org.tensorflow.lite.examples.imageclassification.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.view.PreviewView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.tensorflow.lite.examples.imageclassification.R;

public final class FragmentCameraBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final Button addWordButton;

  @NonNull
  public final InfoBottomSheetBinding bottomSheetLayout;

  @NonNull
  public final CoordinatorLayout cameraContainer;

  @NonNull
  public final RecyclerView recyclerviewResults;

  @NonNull
  public final Button sendQueryButton;

  @NonNull
  public final PreviewView viewFinder;

  private FragmentCameraBinding(@NonNull CoordinatorLayout rootView, @NonNull Button addWordButton,
      @NonNull InfoBottomSheetBinding bottomSheetLayout, @NonNull CoordinatorLayout cameraContainer,
      @NonNull RecyclerView recyclerviewResults, @NonNull Button sendQueryButton,
      @NonNull PreviewView viewFinder) {
    this.rootView = rootView;
    this.addWordButton = addWordButton;
    this.bottomSheetLayout = bottomSheetLayout;
    this.cameraContainer = cameraContainer;
    this.recyclerviewResults = recyclerviewResults;
    this.sendQueryButton = sendQueryButton;
    this.viewFinder = viewFinder;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCameraBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCameraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_camera, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCameraBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_word_button;
      Button addWordButton = ViewBindings.findChildViewById(rootView, id);
      if (addWordButton == null) {
        break missingId;
      }

      id = R.id.bottom_sheet_layout;
      View bottomSheetLayout = ViewBindings.findChildViewById(rootView, id);
      if (bottomSheetLayout == null) {
        break missingId;
      }
      InfoBottomSheetBinding binding_bottomSheetLayout = InfoBottomSheetBinding.bind(bottomSheetLayout);

      CoordinatorLayout cameraContainer = (CoordinatorLayout) rootView;

      id = R.id.recyclerview_results;
      RecyclerView recyclerviewResults = ViewBindings.findChildViewById(rootView, id);
      if (recyclerviewResults == null) {
        break missingId;
      }

      id = R.id.send_query_button;
      Button sendQueryButton = ViewBindings.findChildViewById(rootView, id);
      if (sendQueryButton == null) {
        break missingId;
      }

      id = R.id.view_finder;
      PreviewView viewFinder = ViewBindings.findChildViewById(rootView, id);
      if (viewFinder == null) {
        break missingId;
      }

      return new FragmentCameraBinding((CoordinatorLayout) rootView, addWordButton,
          binding_bottomSheetLayout, cameraContainer, recyclerviewResults, sendQueryButton,
          viewFinder);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
