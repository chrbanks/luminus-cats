-- :name create-cat! :! :n
-- :doc creates a new cat record
INSERT INTO cats
(name, owner, size, timestamp)
VALUES (:name, :owner, :size, :timestamp)

-- :name update-cat! :! :n
-- :doc update an existing cat record
UPDATE cats
SET name = :name, owner = :owner, size = :size
WHERE id = :id

-- :name get-cat :? :1
-- :doc retrieve a cat given the id.
SELECT * FROM cats
WHERE id = :id

-- :name get-cats
-- :doc get list of cats
SELECT * FROM cats

-- :name delete-cat! :! :n
-- :doc delete a cat given the id
DELETE FROM cats
WHERE id = :id
