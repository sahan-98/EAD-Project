// Generated by view binder compiler. Do not edit!
package com.ead.fuelmart.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ead.fuelmart.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FilterPageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ListView listView;

  @NonNull
  public final Spinner spinnerDistrict;

  @NonNull
  public final Spinner spinnerTown;

  @NonNull
  public final TextView textDistrict;

  @NonNull
  public final TextView textProvince;

  @NonNull
  public final TextView textStation;

  private FilterPageBinding(@NonNull ConstraintLayout rootView, @NonNull ListView listView,
      @NonNull Spinner spinnerDistrict, @NonNull Spinner spinnerTown,
      @NonNull TextView textDistrict, @NonNull TextView textProvince,
      @NonNull TextView textStation) {
    this.rootView = rootView;
    this.listView = listView;
    this.spinnerDistrict = spinnerDistrict;
    this.spinnerTown = spinnerTown;
    this.textDistrict = textDistrict;
    this.textProvince = textProvince;
    this.textStation = textStation;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FilterPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FilterPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.filter_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FilterPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.listView;
      ListView listView = ViewBindings.findChildViewById(rootView, id);
      if (listView == null) {
        break missingId;
      }

      id = R.id.spinnerDistrict;
      Spinner spinnerDistrict = ViewBindings.findChildViewById(rootView, id);
      if (spinnerDistrict == null) {
        break missingId;
      }

      id = R.id.spinnerTown;
      Spinner spinnerTown = ViewBindings.findChildViewById(rootView, id);
      if (spinnerTown == null) {
        break missingId;
      }

      id = R.id.textDistrict;
      TextView textDistrict = ViewBindings.findChildViewById(rootView, id);
      if (textDistrict == null) {
        break missingId;
      }

      id = R.id.textProvince;
      TextView textProvince = ViewBindings.findChildViewById(rootView, id);
      if (textProvince == null) {
        break missingId;
      }

      id = R.id.textStation;
      TextView textStation = ViewBindings.findChildViewById(rootView, id);
      if (textStation == null) {
        break missingId;
      }

      return new FilterPageBinding((ConstraintLayout) rootView, listView, spinnerDistrict,
          spinnerTown, textDistrict, textProvince, textStation);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}