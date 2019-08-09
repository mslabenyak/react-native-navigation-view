using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Navigation.View.RNNavigationView
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNNavigationViewModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNNavigationViewModule"/>.
        /// </summary>
        internal RNNavigationViewModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNNavigationView";
            }
        }
    }
}
