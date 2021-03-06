package org.http4s.blaze.channel.nio1

import java.nio.ByteBuffer

/** Type that can be registered with a [[SelectorLoop]]
  *
  * When registered with a `SelectorLoop` it will be notified
  * when it has events ready.
  */
private trait Selectable {

  /** Called by the `SelectorLoop` when events are ready
    *
    * @param scratch a `ByteBuffer` that can be used for scratch area.
    *                This buffer is strictly borrowed for the life of the
    *                method call and will be passed to other `Selectable`
    *                instances.
    */
  def opsReady(scratch: ByteBuffer): Unit

  /** Close this `Selectable` and release associated resources.
    *
    * This close method represents closure under normal conditions.
    */
  def close(): Unit

  /** Close this `Selectable` and release associated resources.
    *
    * This close method represents closure under exceptional conditions.
    */
  def closeWithError(cause: Throwable): Unit
}
