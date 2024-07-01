import { useState, useEffect, useRef } from "react";
import PropTypes from "prop-types";
import "./modal.scss";

function Modal({ active = false, id = "", children }) {
  const [isActive, setIsActive] = useState(false);

  useEffect(() => {
    setIsActive(active);
  }, [active]);

  return (
    <div id={id} className={`modal ${isActive ? "active" : ""}`}>
      {children}
    </div>
  );
}

Modal.propTypes = {
  active: PropTypes.bool,
  id: PropTypes.string,
  children: PropTypes.node.isRequired,
};

export function ModalContent({ onClose = null, children }) {
  const contentRef = useRef(null);

  function closeModal() {
    contentRef.current.parentNode.classList.remove("active");
    if (onClose) onClose();
  }

  return (
    <div ref={contentRef} className="modal__content">
      {children}
      <div className="modal__content__close" onClick={closeModal}>
        <i className="bx bx-x"></i>
      </div>
    </div>
  );
}

ModalContent.propTypes = {
  onClose: PropTypes.func,
  children: PropTypes.node.isRequired,
};

export default Modal;
